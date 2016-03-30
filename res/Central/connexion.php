<?php


if(isset($_GET["action"])){
	$hostname="pedago02a.univ-avignon.fr";
	$username="uapv1600538";
	$password="76y6Wm";

	switch ($_GET["action"]) {
		case 'login':
		try {
			$dbh = new PDO("pgsql:host=$hostname;dbname=etd",$username,$password);

			$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 

			$sql = "SELECT *
			FROM profile WHERE username='".$_GET['username']."' AND password='".$_GET['password']."'";

			$resultat=$dbh->query($sql);
			if($resultat->rowCount()>=1) {
				
				echo '1';exit(0);
			}else{
				echo '0';exit(0);
			}

			$dbh = null;
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}
		break;

		case 'getProfiles':
		try {
			$dbh = new PDO("pgsql:host=$hostname;dbname=etd",$username,$password);

			$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 

			$sql = "SELECT * FROM profile";

			$resultat=$dbh->query($sql);
			if($resultat->rowCount()>=1) {
				$res="";
				$SEPARATOR=',';
				foreach ($resultat as $key => $value) {

					$res.=$value['username'].$SEPARATOR.$value['country'].$SEPARATOR.(isset($value['eloRank'])?$value['eloRank']:0).$SEPARATOR.$value['email'].$SEPARATOR.$value['password']."|";
				}

				echo $res;exit(0);
			}else{
				echo '0';exit(0);
			}

			$dbh = null;
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}
		break;

		case 'verefication':
		try {
			$dbh = new PDO("pgsql:host=$hostname;dbname=etd",$username,$password);

			$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 

			$sql = "SELECT *
			FROM profile WHERE username='".$_GET['username']."' AND password='".$_GET['password']."'";

			$resultat=$dbh->query($sql);
			if($resultat->rowCount()>=1) {
				
				echo '1';exit(0);
			}else{
				echo '0';exit(0);
			}

			$dbh = null;
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}
		break;

		case 'getProfiles':
		try {
			$dbh = new PDO("pgsql:host=$hostname;dbname=etd",$username,$password);

			$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 

			$sql = "SELECT * FROM profile";
			$resultat=$dbh->query($sql);
			if($resultat->rowCount()>=1) {
				$res="";
				$SEPARATOR=',';
				foreach ($resultat as $key => $value) {

					$res.=$value['username'].$SEPARATOR.$value['country'].$SEPARATOR.(isset($value['eloRank'])?$value['eloRank']:0).$SEPARATOR.$value['email'].$SEPARATOR.$value['password']."|";
				}
				echo $res;exit(0);
			}else{
				echo '0';exit(0);
			}

			$dbh = null;
		}
		catch(PDOException $e)
		{
			echo $e->getMessage();
		}
		break;

		case 'singup':
		try {
			$dbh = new PDO("pgsql:host=$hostname;dbname=etd",$username,$password);

			$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 
			$sql = "INSERT INTO profile(password ,email , elorank, country,username) VALUES ('".$_GET['password']."' , '".$_GET['email']."', '".$_GET['eloRank']."', '".$_GET['country']."', '".$_GET['username']."')";

			$resultat=$dbh->query($sql);
			echo '1';exit(0);
			$dbh = null;
		}
		catch(PDOException $e)
		{
			echo '0';exit(0);
		}
		break;

		case 'remove':
		try {
			$dbh = new PDO("pgsql:host=$hostname;dbname=etd",$username,$password);

			$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 
			//pg_query 
			$sql = "DELETE FROM profile WHERE password='".$_GET['password']."' AND username='".$_GET['username']."'";

			$resultat=$dbh->query($sql);

			echo '1';exit(0);

			$dbh = null;
		}
		catch(PDOException $e)
		{
			echo '0';exit(0);
		}
		break;
	}
}

?>