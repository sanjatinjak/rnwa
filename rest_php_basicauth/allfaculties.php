<?php

$username = null;
$password = null;

// mod_php
if (isset($_SERVER['PHP_AUTH_USER'])) {
    $username = $_SERVER['PHP_AUTH_USER'];
    $password = $_SERVER['PHP_AUTH_PW'];

// most other servers
} elseif (isset($_SERVER['HTTP_AUTHORIZATION'])) {

        if (strpos(strtolower($_SERVER['HTTP_AUTHORIZATION']),'basic')===0)
          list($username,$password) = explode(':',base64_decode(substr($_SERVER['HTTP_AUTHORIZATION'], 6)));

}

if (is_null($username) || $username != "efna" || $password != "efna") {

    header('WWW-Authenticate: Basic realm="My Realm"');
    header('HTTP/1.0 401 Unauthorized');
    echo 'Text to send if user hits Cancel button';

    die();

} else {

// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

// include database and object files
include_once 'connection.php';
include_once 'faculties.php';

// instantiate database and product object
$connection = new Connection();
$db = $connection->getConnstring();

// initialize object
$faculties = new Faculties($db);

// query products
$stmt = $faculties->getAllFaculties();

echo $stmt;
}