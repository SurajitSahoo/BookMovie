import { useState } from "react";

import { createBooking } from "../services/bookingService";

import { useAuth } from "../context/AuthContext";

import { toast } from "react-toastify";

const BookingModal = ({
  movie,
  showId,
  onClose
}) => {

  const { user } = useAuth();

  const [seatCount,setSeatCount] =
    useState(1);

  const [seatNumbers,setSeatNumbers] =
    useState("");

  const handleBooking = async () => {

    try {

      const bookingData = {

        userId: user.userId,

        showId: showId,

        numberOfSeats: seatCount,

        seatNumbers:
          seatNumbers
            .split(",")
            .map(s => s.trim())
      };

      await createBooking(
        bookingData
      );

      toast.success(
        "Booking Created"
      );

      onClose();

    } catch(error){

      toast.error(
        error?.response?.data ||
        "Booking Failed"
      );
    }
  };

  return (

    <div
      className="
      fixed
      inset-0
      bg-black/70
      flex
      justify-center
      items-center
      z-50
      "
    >

      <div
        className="
        bg-slate-900
        p-6
        rounded-xl
        w-[90%]
        md:w-[500px]
        "
      >

        <h2
          className="
          text-2xl
          font-bold
          mb-4
          "
        >
          {movie.name}
        </h2>

        <input
          type="number"
          min="1"
          value={seatCount}
          onChange={(e)=>
            setSeatCount(
              Number(e.target.value)
            )
          }
          placeholder="Seats"
          className="
          w-full
          p-3
          bg-slate-800
          rounded-lg
          mb-4
          "
        />

        <input
          type="text"
          value={seatNumbers}
          onChange={(e)=>
            setSeatNumbers(
              e.target.value
            )
          }
          placeholder="A1,A2,A3"
          className="
          w-full
          p-3
          bg-slate-800
          rounded-lg
          mb-4
          "
        />

        <div
          className="
          flex
          gap-3
          "
        >

          <button

            onClick={handleBooking}

            className="
            flex-1
            bg-green-500
            py-2
            rounded-lg
            "
          >
            Confirm
          </button>

          <button

            onClick={onClose}

            className="
            flex-1
            bg-red-500
            py-2
            rounded-lg
            "
          >
            Cancel
          </button>

        </div>

      </div>

    </div>

  );
};

export default BookingModal;