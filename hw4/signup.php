
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
<body>
<form method="post" action="signup-submit.php">
    <fieldset>
        <legend>New User Signup:</legend>
        <div class="column">
            <header>
                <h1>Name:</h1>
                <h1>Gender:</h1>
                <h1>Age:</h1>
                <h1>Personality type:</h1>
                <h1>Favorite OS:</h1>
                <h1>Seeking age:</h1>
                <input type="submit" value="Sign Up">
            </header>
        </div>
        <input class="right" type="text" name="name" size="16">
        <div class="right"> <input type="radio" name="gender" value="male"> Male
            <input type="radio" name="gender" value="female" checked="checked"> Female</div>
        <input class="right" type="text" name="age" size="6" maxlength="2"><br/>
        <input class="right" type="text" name="type" size="6"
               maxlength="4">
        (<a href="http://www.humanmetrics.com/cgi-win/JTypes2.asp">Don't know your type?</a>)<br/>
        <select class="right">
            <option selected>Windows</option>
            <option>Mac OS X</option>
            <option>Linux</option>
        </select><br/>
        <input type="text" name="min" size="6" maxlength="2" placeholder="min">
        to <input type="text" name="max" size="6" maxlength="2" placeholder="max">
    </fieldset>
</form>
</div>
</body>
</html>

<?php include("bottom.html"); ?>