<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForma.aspx.cs" Inherits="rnwa2020.WebForma" %>


<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <title></title>
</head>
<body>

    <style>
        hr {
            width: 50px;
            color: black;
        }
    </style>

    <div class="container">


        <div class="row">
            <div class="col-sm-7">

                <br />

                <form class="podaci" runat="server" style="float: right;">
                    <div>
                        <br />
                        <label>Odaberite kolegij </label>
                        &nbsp;
                    </div>

                    <input id="unos" type="text" runat="server" />

                    <asp:Button ID="dugme" runat="server" Text="Button" OnClick="dugme_Click" />

                </form>

            </div>
        </div>

        <div class="row">
            <div class="col-sm-9" style="float: right; padding-left: 90px; padding-top: 20px;">
                &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
                <span><b>Student ID </b></span>&nbsp;&nbsp;
                 <span><b>Fakultet ID </b></span>&nbsp;&nbsp;&nbsp;
                <span><b>Ime i prezime </b></span>&nbsp;&nbsp;
               
            </div>
        </div>
        <br />
        <div class="row">

            <div class="col-sm-9" style="float: right; padding-left: 90px;">
                <span runat="server" id="rezultat"></span>&nbsp;&nbsp;

            </div>
        </div>



    </div>


</body>
</html>
