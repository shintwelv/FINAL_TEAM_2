import React, { useState } from 'react'
import { Rating } from 'react-simple-star-rating'

export default function StarRating() {
  const [rating, setRating] = useState(0) // initial rating value

  // Catch Rating value
  const handleRating = (rate) => {
    setRating(rate)
    // Some logic
  }

  return (
    <div className="App">
      <Rating
        onClick={handleRating}
        ratingValue={rating}
        size={32} //default 25px
        fillColor={'#0593f0'}
      />
    </div>
  )
}
