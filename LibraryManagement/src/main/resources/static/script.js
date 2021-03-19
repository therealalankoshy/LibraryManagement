function mainfunc() {
  var request = new XMLHttpRequest();
  backend_path = "http://localhost:9090"
  API_URL = "/api/book/search"
  final_query = backend_path+API_URL
  console.log("Final API URL is: " + final_query);

  var sendDate = (new Date()).getTime();
  myBody = generateRequestBody();
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
       if (this.readyState == 4 && this.status == 200) {
         var original = JSON.parse(this.response);
        var data = original;
        document.getElementById("loader").style.display = 'none'; 
        // console.log(data);
        // console.log(removeduplicates(data,'bookData'))
        //data= console.log(removeduplicates(data));
        data = listFormat(removeduplicates(data,'bookName'));
        test(data,'#table')
        window.onload = addRowHandlers(original);
       }
  };
  xhttp.open("POST", final_query, true);
  xhttp.setRequestHeader("Content-type", "application/json");
  xhttp.send(myBody);

  document.getElementById("loader").style.display = 'inline-block';
}
function generateRequestBody()
{
  var searchWord = document.getElementById("search").value;
  var authorName = document.getElementById("authors").value;
  var categoryName = document.getElementById("category").value;
  var requestString = ""

  dataa = createObjStructure(searchWord,authorName,categoryName)
  requestString = "["+dataa+"]"

  // if(searchWord!="")
  // {
    
  //   dataa = createObjStructure(searchWord,authorName,categoryName)
  //   requestString = "["+dataa+"]"
  // }
  // else
  // {
  //   alert("Enter a Search Word");
  //   resetformData();
  //   return;
  // }

  console.log(searchWord);
  return requestString
}

function createObjStructure(searchWord,authorName,categoryName)
{
  var searchWordObject =     {
    "key": "bookName",
    "operation": ":",
    "value": searchWord
};
var authorNameObject =     {
  "key": "authorName",
  "operation": ":",
  "value": authorName
};
var categoryNameObject =     {
  "key": "categoryName",
  "operation": ":",
  "value": categoryName
};
return JSON.stringify(searchWordObject)+","+JSON.stringify(authorNameObject)+","+JSON.stringify(categoryNameObject);
} 
        
function test(listdata,selectorString)
{
  constructTable(selectorString,listdata)
}

function constructTable(selector,list) { 
  if(list.length==0)
    {
      $(selector).html('');
      return 
    }
              
  // Getting the all column names 
  var cols = Headers(list, selector);   

  // Traversing the JSON data 
  for (var i = 0; i < list.length; i++) { 
      var row = $('<tr/>');    
      for (var colIndex = 0; colIndex < cols.length; colIndex++) 
      { 
          var val = list[i][cols[colIndex]]; 
            
          // If there is any key, which is matching 
          // with the column name 
          if (val == null) val = "";   
              row.append($('<td/>').html(val)); 
      } 
        
      // Adding each row to the table 
      $(selector).append(row); 
  } 
}

function Headers(list, selector) { 
  var columns = []; 
  var header = $('<tr/>'); 
    
  for (var i = 0; i < list.length; i++) { 
      var row = list[i]; 
        
      for (var k in row) { 
          if ($.inArray(k, columns) == -1) { 
              columns.push(k); 
                
              // Creating the header 
              header.append($('<th/>').html(k)); 
          } 
      } 
  } 
    
  // Appending the header to the table 
  $(selector).append(header); 
      return columns; 
}

function removeduplicates(arr, key) {
  return [...new Map(arr.map(item => [item[key], item])).values()]
}

function listFormat(arr) {
  var returnlist = []
  for (let i = 0; i < arr.length; i++) {
    var element = (({ bookId,bookName,categoryName,authorName}) => ({ bookId,bookName,categoryName,authorName }))(arr[i]);
    returnlist.push(element);
  }
  return returnlist;
}

function resetformData()
{
  document.getElementById("search").value='';
  document.getElementById("authors").value='';
  document.getElementById("category").value='';
  constructTable('#table',[]);
  constructTable('#detailtable',[]);
}

function addRowHandlers(data) {
  var table = document.getElementById("table");
  var rows = table.getElementsByTagName("tr");
  for (i = 0; i < rows.length; i++) {
      var currentRow = table.rows[i];
      var createClickHandler = 
          function(row) 
          {
              return function() { 
                                      var cell = row.getElementsByTagName("td")[0];
                                      var id = cell.innerHTML;
                                      showBookDrillDown(id,data);
                               };
          };

      currentRow.onclick = createClickHandler(currentRow);
  }
}


function showBookDrillDown(id,data)
{
  console.log(data)
  console.log(id)
  var tempLit = [];
  for (i = 0; i < data.length; i++)
  {
    if(data[i]["bookId"]==id)
    {
      data[i]['issueDateCreated'] = changeDateFormat(data[i]['issueDateCreated']);
      data[i]['issueLastUpdated'] = changeDateFormat(data[i]['issueLastUpdated']);
      data[i]['issueDateIssued'] = changeDateFormat(data[i]['issueDateIssued']);
      data[i]['issueDateDue'] = changeDateFormat(data[i]['issueDateDue']);
      data[i]['issueReturnDate'] = changeDateFormat(data[i]['issueReturnDate']);
      tempLit.push(data[i]);
    }
  }
  console.log(tempLit)
  constructTable('#detailtable',tempLit);
}

function changeDateFormat(epochDateString)
{
  if(epochDateString!=null)
  {
    var utcSeconds = epochDateString;
    var d = new Date(utcSeconds*100);
    return d;
  }
  else
    return epochDateString;
}
