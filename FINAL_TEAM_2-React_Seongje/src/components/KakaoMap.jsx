import React, { useEffect } from 'react'

const { kakao } = window

const KakaoMap = (props) => {
  useEffect(() => {
    let container = document.getElementById('map')

    let options = {
      center: new kakao.maps.LatLng(props.lng, props.lat),
      level: 3,
    }

    let map = new kakao.maps.Map(container, options)
    map.setDraggable(false)
    map.setZoomable(false)

    // 마커가 표시될 위치입니다
    var markerPosition = new kakao.maps.LatLng(props.lng, props.lat)

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
      position: markerPosition,
    })

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map)

    // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
    // marker.setMap(null);

    console.log('loading kakaomap')
  }, [])

  return <div id="map" style={{ width: '100%', height: '100%' }}></div>
}

export default KakaoMap
