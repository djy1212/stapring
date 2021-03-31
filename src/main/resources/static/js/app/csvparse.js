function getExcelFile() {
    const fObj = document.getElementById("selfile");
    console.log(fObj.value);
    if(fObj.value === '') {
        alert('Please Select File');
    } else {
        const selectedFile = fObj.files[0];
        console.log(selectedFile.path);
        console.log('Name :' + selectedFile.name + '/ Size : ' + selectedFile.size);

        var reader = new FileReader();
        reader.onload = function(evt) {
            if(evt.target.readyState == FileReader.DONE) {
                var data = evt.target.result;
                console.log(data);
                var fileData = reader.result;
                console.log(fileData);
                data = new Uint8Array(data);
                console.log(data);
                // call 'xlsx' to read the file
                var workbook = XLSX.read(data, {type: 'array'});
                console.log(workbook);
                console.log(workbook.Sheets['Sheet1']);
                //alert(workbook.Sheets['Sheet1']['A1']['v']);
                //var toJson = XLSX.utils.sheet_to_json(workbook.Sheets['Sheet1']);
                //console.log(JSON.stringify(toJson));
                var grid = document.getElementById("target-variable-dropdown");
                var arr1 = workbook.Sheets['Sheet1'];
                for (var key in arr1) {
                    console.log("key : " + key +", value : " + arr1[key]);
                    var newA = document.createElement("a");
                    newA.innerHTML = arr1[key]['v'];
                    newA.setAttribute("class","dropdown-item");
                    newA.setAttribute("value",arr1[key]);
                    grid.appendChild(newA);
                }
            }
        };
        reader.readAsArrayBuffer(selectedFile);
    }
}
