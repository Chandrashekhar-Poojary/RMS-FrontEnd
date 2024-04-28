var HTML = `<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        <div class="logout">
            <button id="logoutButton">Logout</button>
        </div>
    </header>
</body>
</html>`

document.getElementById('header').innerHTML =HTML;

