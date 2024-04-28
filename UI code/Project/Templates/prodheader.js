var HTML = `<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/ec241f5171.js" crossorigin="anonymous"></script>
    <title>Header</title>
    <style >
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            /* position: fixed; */
            background-color: #f0f0f0;
            padding: 10px 20px;
        }

        .logout button {
            background-color: #6c34ea;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 6px 16px;
            cursor: pointer;
            font-size: larger;
        }
    </style>
</head>
<body>
    <header>
        <div class="logo">
           <a href="C:\\_My_Files\\RMS\\UI code\\Project\\AdminDb\\AdminDashboardPage.html"><img src="C:\\_My_Files\\RMS\\photos\\Syncsale.jpg" alt="Company Logo"></a>
        </div>
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                 ALL CATEGORY
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">Vegetables & Fruits</a>
                <a class="dropdown-item" href="#">Cerals</a>
                <a class="dropdown-item" href="#">Cleaning and Hygiene</a>
                <a class="dropdown-item" href="#">Packaged Foods</a>
            </div>
        </div>
     
        
        <div class="logout">
            <button type="button" class="btn btn-secondary">Add Category</button>
            <button id="logoutButton">Logout</button>
            
        </div>
    </header>
</body>
</html>`

document.getElementById('header').innerHTML =HTML;

