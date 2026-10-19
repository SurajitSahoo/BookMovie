import {
  useEffect,
  useState
} from "react";

import {
  getUserBookings,
  cancelBooking
} from "../../services/bookingService";

import {
  useAuth
} from "../../context/AuthContext";

import {
  toast
} from "react-toastify";

const Bookings = () => {

  const { user } =
    useAuth();

  const [bookings,setBookings] =
    useState([]);

  useEffect(() => {

    fetchBookings();

  },[]);

  const fetchBookings =
    async () => {

      try {

        const data =
          await getUserBookings(
            user.userId
          );

        setBookings(data);

      } catch(error){

        toast.error(
          "Failed to fetch bookings"
        );
      }
    };

  const handleCancel =
    async (id) => {

      try {

        await cancelBooking(id);

        toast.success(
          "Booking Cancelled"
        );

        fetchBookings();

      } catch(error){

        toast.error(
          error?.response?.data
        );
      }
    };

  return (

    <div
      className="
      p-6
      "
    >

      <h1
        className="
        text-3xl
        font-bold
        mb-6
        "
      >
        My Bookings
      </h1>

      <div
        className="
        grid
        md:grid-cols-2
        gap-5
        "
      >

        {bookings.map((booking) => (
  <div key={booking.bookingId}>
    ...
  </div>
))}

      </div>

    </div>
  );
};

export default Bookings;