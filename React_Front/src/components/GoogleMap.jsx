import React from 'react'
import { GoogleMap, LoadScript } from '@react-google-maps/api'

const containerStyle = {
  width: '400px',
  height: '400px',
}

const center = {
  lat: 37.587642,
  lng: 127.000656,
}

function GoogleMapComp(props) {
  return (
    <LoadScript googleMapsApiKey="AIzaSyC9_9Asxaf37xoF-95lN6YRw-5ZuYYpfoA">
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={10}
      ></GoogleMap>
    </LoadScript>
  )
}

export default GoogleMapComp
