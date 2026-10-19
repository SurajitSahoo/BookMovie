import {
 useEffect,
 useState
}
from "react";

import api
from "../../api/axios";

const AllBookings = () => {

 const [bookings,
 setBookings] =
 useState([]);

 useEffect(()=>{

  loadBookings();

 },[]);

 const loadBookings =
 async()=>{

  const res =
  await api.get(
   "/api/booking/getshowbookings/1"
  );

  setBookings(
   res.data
  );
 };

 return(

  <div>

   <h1
   className="
   text-3xl
   font-bold
   mb-5
   "
   >
    All Bookings
   </h1>

   <div
   className="
   overflow-x-auto
   "
   >

    <table
    className="
    w-full
    bg-slate-800
    rounded-xl
    "
    >

     <thead>

      <tr>

       <th>ID</th>

       <th>User</th>

       <th>Movie</th>

       <th>Seats</th>

       <th>Status</th>

       <th>Amount</th>

      </tr>

     </thead>

     <tbody>

      {
       bookings.map(
       booking => (

        <tr
        key={
         booking.bookingId
        }
        >

         <td>
          {
           booking.bookingId
          }
         </td>

         <td>
          {
           booking.username
          }
         </td>

         <td>
          {
           booking.movieName
          }
         </td>

         <td>
          {
           booking.numberOfSeats
          }
         </td>

         <td>
          {
           booking.bookingStatus
          }
         </td>

         <td>
          ₹
          {
           booking.price
          }
         </td>

        </tr>

       ))
      }

     </tbody>

    </table>

   </div>

  </div>

 );
};

export default AllBookings;