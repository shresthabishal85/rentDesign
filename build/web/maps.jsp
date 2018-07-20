<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MAPS</title>

<style>
    #map{
      height:600px;
      width:100%;
    }
  </style>
</head>
<body>
  <h1>My Google Map</h1>
  <div id="map"></div>
  <script>
    function initMap(){
      // Map options
      var options = {
        zoom:8,
        center:{lat:28.394857,lng:84.124008}
      }
    

      // New map
      var map = new google.maps.Map(document.getElementById('map'), options);
      // Listen for click on map
     google.maps.event.addListener(map, 'click', function(event){
        // Add marker
                
                addMarker({coords:event.latLng});
                console.log(event.latLng.toLocaleString());
                
               // var loc= marker.getPosition();
               // alert("lelelele");
      });

      /*
      // Add marker
      var marker = new google.maps.Marker({
        position:{lat:42.4668,lng:-70.9495},
        map:map,
        icon:'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png'
      });

      var infoWindow = new google.maps.InfoWindow({
        content:'<h1>Lynn MA</h1>'
      });

      marker.addListener('click', function(){
        infoWindow.open(map, marker);
      });
      */

      // Array of markers
      var markers = [
        {
          coords:{lat:42.4668,lng:-70.9495},
          iconImage:'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
          content:'<h1>Lynn MA</h1>'
        },
        {
          coords:{lat:42.8584,lng:-70.9300},
          content:'<h1>Amesbury MA</h1>'
        },
        {
          coords:{lat:42.7762,lng:-71.0773}
        }
      ];

      // Loop through markers
      for(var i = 0;i < markers.length;i++){
        // Add marker
        addMarker(markers[i]);
      }

      // Add Marker Function
      function addMarker(props){
        var marker = new google.maps.Marker({
          position:props.coords,
          map:map,
          //icon:props.iconImage
        });
        
        // Check for customicon
        if(props.iconImage){
          // Set icon image
          marker.setIcon(props.iconImage);
        }

        // Check content
        if(props.content){
          var infoWindow = new google.maps.InfoWindow({
            content:props.content
          });

          marker.addListener('click', function(){
            infoWindow.open(map, marker);
          });
        }
      }
    }
  </script>
  
   <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=
AIzaSyCeh88_dADHcrQDd4j4DMvLV-EffYCN_30&callback=initMap">
    </script>

</body>
</html>
