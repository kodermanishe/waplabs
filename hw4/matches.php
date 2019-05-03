<?php include("top.html"); ?>

<!-- CSE 190 M, Homework 4 (NerdLuv)
     This provided file is the front page that links to two of the files you are going
     to write, signup.php and matches.php.  You don't need to modify this file. -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="nerdluv.css" type="text/css" rel="stylesheet">
</head>
<form method="post" action="matches-submit.php">
    <fieldset>
        <legend>Returning user:</legend>
        <h1><label class="left">Name:</label><input type="text" name="name" size="16"></h1>
        <input type="submit" value="View My Matches">
    </fieldset>
</form>
</div>
</body>
</html>

<?php include("bottom.html"); ?>
