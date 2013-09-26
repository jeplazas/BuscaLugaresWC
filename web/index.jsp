<%-- 
    Document   : index
    Created on : 24/09/2013, 09:36:17 PM
    Author     : Julião
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlacesSearchWC</title>
        
        <style type="text/css">
            html{
                background-image: url(resources/paradise3.jpg);
                font-family: cursive;
                font-style: italic;
                font-weight: bolder;
                font-size: larger;
            }
        </style>
        
    </head>
    <body>
        <center>
            <h1>Places Search Web Service</h1>
            <h5>Powered by GooglePlaces</h5>
            <br/><br/><br/><br/><br/>
            <h3>Search Details</h3>
            <form name="basic1" action="BuscaLugaresServlet">
                <table border="0" cellspacing="2" cellpadding="10" align="center">
                    <tr>
                        <td>
                            Place:
                        </td>
                        <td>
                            <input type="text" name="query" placeholder="place" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            City:
                        </td>
                        <td>
                            <input type="text" name="place" placeholder="city" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Type:
                        </td>
                        <td>
                            <select name="type">
                                <option></option>
                                <option>accounting</option>
                                <option>airport</option>
                                <option>amusement_park</option>
                                <option>aquarium</option>
                                <option>art_gallery</option>
                                <option>atm</option>
                                <option>bakery</option>
                                <option>bank</option>
                                <option>bar</option>
                                <option>beauty_salon</option>
                                <option>bicycle_store</option>
                                <option>book_store</option>
                                <option>bowling_alley</option>
                                <option>bus_station</option>
                                <option>cafe</option>
                                <option>campground</option>
                                <option>car_dealer</option>
                                <option>car_rental</option>
                                <option>car_repair</option>
                                <option>car_wash</option>
                                <option>casino</option>
                                <option>cemetery</option>
                                <option>church</option>
                                <option>city_hall</option>
                                <option>clothing_store</option>
                                <option>convenience_store</option>
                                <option>courthouse</option>
                                <option>dentist</option>
                                <option>department_store</option>
                                <option>doctor</option>
                                <option>electrician</option>
                                <option>electronics_store</option>
                                <option>embassy</option>
                                <option>establishment</option>
                                <option>finance</option>
                                <option>fire_station</option>
                                <option>florist</option>
                                <option>food</option>
                                <option>funeral_home</option>
                                <option>furniture_store</option>
                                <option>gas_station</option>
                                <option>general_contractor</option>
                                <option>grocery_or_supermarket</option>
                                <option>gym</option>
                                <option>hair_care</option>
                                <option>hardware_store</option>
                                <option>health</option>
                                <option>hindu_temple</option>
                                <option>home_goods_store</option>
                                <option>hospital</option>
                                <option>insurance_agency</option>
                                <option>jewelry_store</option>
                                <option>laundry</option>
                                <option>lawyer</option>
                                <option>library</option>
                                <option>liquor_store</option>
                                <option>local_government_office</option>
                                <option>locksmith</option>
                                <option>lodging</option>
                                <option>meal_delivery</option>
                                <option>meal_takeaway</option>
                                <option>mosque</option>
                                <option>movie_rental</option>
                                <option>movie_theater</option>
                                <option>moving_company</option>
                                <option>museum</option>
                                <option>night_club</option>
                                <option>painter</option>
                                <option>park</option>
                                <option>parking</option>
                                <option>pet_store</option>
                                <option>pharmacy</option>
                                <option>physiotherapist</option>
                                <option>place_of_worship</option>
                                <option>plumber</option>
                                <option>police</option>
                                <option>post_office</option>
                                <option>real_estate_agency</option>
                                <option>restaurant</option>
                                <option>roofing_contractor</option>
                                <option>rv_park</option>
                                <option>school</option>
                                <option>shoe_store</option>
                                <option>shopping_mall</option>
                                <option>spa</option>
                                <option>stadium</option>
                                <option>storage</option>
                                <option>store</option>
                                <option>subway_station</option>
                                <option>synagogue</option>
                                <option>taxi_stand</option>
                                <option>train_station</option>
                                <option>travel_agency</option>
                                <option>university</option>
                                <option>veterinary_care</option>
                                <option>zoo</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Search" name="Place_Search" />
            </form>
        </center>
    </body>
</html>

