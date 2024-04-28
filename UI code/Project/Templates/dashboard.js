var html = `<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap-grid.min.css" integrity="sha512-i1b/nzkVo97VN5WbEtaPebBG8REvjWeqNclJ6AItj7msdVcaveKrlIIByDpvjk5nwHjXkIqGZscVxOrTb9tsMA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    
    <title>Web Application</title>
    <style>
        
    body {
        display: flex;
        flex-direction: column;
        height: 100%;
        
        font-family: Arial, sans-serif;
    }
    
       
        .sidebar {
            background:linear-gradient(to top, #8576FF,#B91CF7 ) ; /* Changed background color */
            /* Changed text color */
            /* background-color: #f1f1f1; */
            width: 200px;
            height: calc(100% - 25px);
            overflow: auto;
            padding: 15px;
            transition: width 0.3s ease;
        }
        .sidebar.collapsed {
            width: 0;
            padding: 0;
            overflow: hidden;
        }
        .sidebar a {
            display: block;
            color: #102C57;
            padding: 10px;
            text-decoration: none;
            /* font-weight: bold; */
            /* margin-bottom: 4px; */
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .sidebar a:hover {
            background-color: #ddd;
        }
        
        #toggleButton {
            position: absolute;
            left: 200px;
            top: 65px;
            transition: left 0.3s ease;
            background-color: #6c34ea;
            color: white;
            border: none;
            padding: 10 px;
            border-radius: 2px;
            font-size: larger;

            
        }
       
    </style>
</head>
<body>
    

        <div class="sidebar" id="sidebar">
            
                <a href="C:\\_My_Files\\RMS\\UI code\\Project\\Orders\\ProductAndCategory.html" >Product & Category</a>
                <a href="#">Customer</a>
                <a href="#">Sales Stats</a>
                <a href="C:\\_My_Files\\RMS\\UI code\\Project\\Company\\CompanyTable.html">Company</a>
                <a href="#">Inventory</a>
                <a href="C:\\_My_Files\\RMS\\UI code\\Project\\Employee\\addemployee.html">Employee</a>
                <a href="xyz.html">Orders</a>
            
        </div>
    
    
    <button id="toggleButton"><i class="bi bi-list">Dashboard</i></button>

    
</body>
</html>
`

document.getElementById('dashboard').innerHTML = html;
