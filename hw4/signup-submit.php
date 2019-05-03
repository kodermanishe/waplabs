<?php include("top.html"); ?>

<!-- CSE 190 M, Homework 4 (NerdLuv)
     This provided file is the front page that links to two of the files you are going
     to write, signup.php and matches.php.  You don't need to modify this file. -->
<div>
	<h1>Thank you!</h1>

    <?php if (isset($_POST["name"])) : ?>
        Welcome to NerdLuv, <?= $_POST["name"] ?>!
    <?php endif; ?>

	<ul>
		<li>
			Now <a href="signup.php">
				<img src="http://www.cs.washington.edu/education/courses/cse190m/12sp/homework/4/signup.gif" alt="icon" />
				log in to see yur matches!
			</a>
		</li>
	</ul>
</div>

<?php include("bottom.html"); ?>
