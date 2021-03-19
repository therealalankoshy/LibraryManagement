function mainfunc() {
  var request = new XMLHttpRequest();
  var search_word = document.getElementById("search").value.toLowerCase();
  //var index_name = document.getElementById("index").value.toLowerCase();
  var index_name = "fullnlpsearch";
  var gram_parameter = document.getElementById("gram").value;
  var days = document.getElementById("days").value;
  var count = document.getElementById("count").value;
  var range = document.getElementById("range").value;
  var range_count = document.getElementById("range_count").value;
  var pos_filter = 0;
  var pos0 = document.getElementById("POS0").checked;
  var pos1 = document.getElementById("POS1").checked;
  var pos2 = document.getElementById("POS2").checked;
  console.log(pos0);
  console.log(pos1);
  console.log(pos2);
  if (pos0 == false && pos1 == false && pos2 == false) {
    console.log("No POS Removed");
    pos_filter = 0;
  }
  if (pos0 == true && pos1 == false && pos2 == false) {
    console.log("Verbs Removed");
    pos_filter = 1;
  }
  if (pos0 == false && pos1 == true && pos2 == false) {
    console.log("Adjectives Removed");
    pos_filter = 2;
  }
  if (pos0 == false && pos1 == false && pos2 == true) {
    console.log("Adverbs Removed");
    pos_filter = 3;
  }
  if (pos0 == true && pos1 == true && pos2 == false) {
    console.log("Verbs and Adjectives Removed");
    pos_filter = 4;
  }
  if (pos0 == false && pos1 == true && pos2 == true) {
    console.log("Adjectives and Adverbs Removed");
    pos_filter = 5;
  }
  if (pos0 == true && pos1 == false && pos2 == true) {
    console.log("Verbs and Adjectives Removed");
    pos_filter = 6;
  }
  if (pos0 == true && pos1 == true && pos2 == true) {
    console.log("Verbs,Adjectives and Adverbs Removed");
    pos_filter = 7;
  }
  console.log("Final POS Value is " + pos_filter);
  var final_query;
  var filter_query = " | filters minGram=" + gram_parameter + ",posfilter=" + pos_filter;
  if (days == "") {
    final_query = "http://cmn-api.inapp.com:9200/_pql?query=source '" + index_name + "' | search description='" + search_word + "' | stats auth_cardinal=cardinality(author) ";
  }
  else if (days != "" && range_count=="") {
    alert("Days Range Count value should be entered !!");
    return false;
  }
  else if (range_count != "" && days=="") {
    alert("Days value should be entered !!");
    return false;
  }
  else if (days != "" && range_count!="") {
    final_query = "http://cmn-api.inapp.com:9200/_pql?query=source '" + index_name + "' | search description='" + search_word + "' | stats auth_cardinal=cardinality(author), range_count=count_by_date_range(timestamp, " + days + ") ";
  }

  if (count != "" && range != "") {
    console.log("Count and Range Value is not Empty");
    //filter_query=" | filters minGram="+gram_parameter+", count>"+count,+"range_count>"+range_count;
    filter_query = " | filters count>" + count + ",auth_cardinal>" + range + ",minGram=" + gram_parameter + ",posfilter=" + pos_filter;
  }
  if (count != "" && range == "") {
    console.log("Count Value is not Empty");
    //filter_query=" | filters minGram="+gram_parameter+", count>"+count;
    filter_query = " | filters count>" + count + ",minGram=" + gram_parameter + ",posfilter=" + pos_filter;
  }
  if (range != "" && count == "") {
    console.log("Range Value is not Empty");
    filter_query = " | filters auth_cardinal>" + range + ",minGram=" + gram_parameter + ",posfilter=" + pos_filter;
  }
  if (days != "") {
    console.log("Range Count Value is not Empty");
    filter_query += ",range_count>" + range_count;
  }

  final_query += filter_query;
  console.log("Final Query is: " + final_query);
  request.open('POST', final_query, true);
  var sendDate = (new Date()).getTime();

  request.onload = function() {
    var data = JSON.parse(this.response);
    var receiveDate = (new Date()).getTime();
    var responseTimeMs = receiveDate - sendDate;

    document.getElementById("loader").style.display = 'none';
    document.getElementById("result").style.display = "none";
    document.getElementById("final_query").style.display = "none";
    document.getElementById("tb1").style.display = "none";
    document.getElementById("tb2").style.display = "none";
    document.getElementById("tb3").style.display = "none";
    document.getElementById("time").style.display = "none";
    document.getElementById('time').value = "Response Time :" + responseTimeMs + " MilliSeconds";

    console.log(responseTimeMs);
    var dbParam = JSON.stringify(data['keywords'], null, 2);
    if(dbParam=="[]")
    {
      dbParam="No Keywords Found with Selected Filtering !!"
    }


    console.log(dbParam);
    var count = function(dbParam) {
      return dbParam;
    };
    document.getElementById('result').value = count(dbParam);
    console.log(data);

    document.getElementById('final_query').value = final_query;
    document.getElementById("result").style.display = "block";
    document.getElementById("final_query").style.display = "block";
    document.getElementById("tb1").style.display = "block";
    document.getElementById("tb2").style.display = "block";
    document.getElementById("tb3").style.display = "block";
    document.getElementById("time").style.display = "block";

    if (request.status >= 200 && request.status < 400) {} else {
      console.log('error');
    }
  }
  request.send();
  document.getElementById("loader").style.display = 'inline-block';
  document.getElementById("final_query").style.display = "none";
  document.getElementById("result").style.display = "none";
  document.getElementById("tb1").style.display = "none";
  document.getElementById("tb2").style.display = "none";
  document.getElementById("tb3").style.display = "none";
  document.getElementById("time").style.display = "none";
}

