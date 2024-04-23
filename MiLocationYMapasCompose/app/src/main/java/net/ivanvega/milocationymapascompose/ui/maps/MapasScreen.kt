package net.ivanvega.milocationymapascompose.ui.maps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker

import com.utsman.osmandcompose.Marker as MarkerOSMD

import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.rememberCameraState
import com.utsman.osmandcompose.rememberMarkerState
import org.osmdroid.util.GeoPoint


@Composable
fun MiMapa(){
    val singapore = LatLng(20.13933,-101.1506)

    val polilyne = listOf(LatLng(20.13933,-101.1506),
        LatLng(20.14340,-101.14987),
        LatLng(20.14385, -101.15101)
    )
    
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Polyline(points = polilyne, color = Color.Red)
        Marker(
            state = MarkerState(position = singapore),
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
}

@Composable
fun MiMapaOSMDroidCompose(){
    // define camera state
    val cameraState = rememberCameraState {
        geoPoint = GeoPoint(20.13933,-101.1506)
        zoom = 12.0 // optional, default is 5.0
    }

    // define marker state
    val depokMarkerState = rememberMarkerState(
        geoPoint = GeoPoint(20.13933,-101.1506)
    )

    // add node
    OpenStreetMap(
        modifier = Modifier.fillMaxSize(),
        cameraState = cameraState
    ){
        // add marker here
        MarkerOSMD(
            state = depokMarkerState
        )
    }
}


