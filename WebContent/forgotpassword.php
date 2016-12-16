<?php
if(isset($_POST['submit']))
{
    $email = $_POST['email'];
    $connect = mysql_connect("127.0.0.1","root","root");
    mysql_select_db("capstone");
    $query = mysql_query("SELECT * FROM registration WHER email = '$email'");
    while($row = mysql_fetch_assoc($query))
    {
        $email1 = $row['email'];
        $password = $row['password'];
        $firstName = $row['firstName'];
    }
    if($email == $email1)
    {
        $from = "Airline Reservation System";
        $to = $email;
        $subject = "Forgot password";
        $body = "Dear $firstName \n Your Email/Username : $email \n password is: $password";
        mail($to,$subject,$body,$from);
        echo "Please check your inbox for the password";
    }
}
else
{
    echo "Please provide correct Email.";
}
?>