import { useEffect, useState } from "react";

import { getMovies } from "../../services/movieService";
import api from "../../api/axios";

const AdminDashboard = () => {

  const [moviesCount, setMoviesCount] = useState(0);
  const [showsCount, setShowsCount] = useState(0);
  const [bookingsCount, setBookingsCount] = useState(0);

  useEffect(() => {
    loadDashboardData();
  }, []);

  const loadDashboardData = async () => {
    try {

      // Movies
      const movies = await getMovies();
      setMoviesCount(movies.length);

      // Shows
      const showsRes = await api.get(
        "/api/show/getallshows"
      );

      setShowsCount(
        showsRes.data.length
      );

      // Bookings
      // Better if you create an API:
      // GET /api/booking/getallbookings

      const bookingRes = await api.get(
        "/api/booking/getallbookings"
      );

      setBookingsCount(
        bookingRes.data.length
      );

    } catch (error) {
      console.error(error);
    }
  };

  return (

    <div>

      <h1
        className="
        text-4xl
        font-bold
        mb-8
        "
      >
        Admin Dashboard
      </h1>

      <div
        className="
        grid
        grid-cols-1
        md:grid-cols-3
        gap-6
        "
      >

        {/* Movies */}

        <div
          className="
          bg-cyan-500
          p-6
          rounded-xl
          shadow-lg
          hover:scale-105
          transition
          "
        >
          <h2
            className="
            text-xl
            font-semibold
            "
          >
            Total Movies
          </h2>

          <p
            className="
            text-4xl
            font-bold
            mt-4
            "
          >
            {moviesCount}
          </p>
        </div>

        {/* Shows */}

        <div
          className="
          bg-pink-500
          p-6
          rounded-xl
          shadow-lg
          hover:scale-105
          transition
          "
        >
          <h2
            className="
            text-xl
            font-semibold
            "
          >
            Total Shows
          </h2>

          <p
            className="
            text-4xl
            font-bold
            mt-4
            "
          >
            {showsCount}
          </p>
        </div>

        {/* Bookings */}

        <div
          className="
          bg-green-500
          p-6
          rounded-xl
          shadow-lg
          hover:scale-105
          transition
          "
        >
          <h2
            className="
            text-xl
            font-semibold
            "
          >
            Total Bookings
          </h2>

          <p
            className="
            text-4xl
            font-bold
            mt-4
            "
          >
            {bookingsCount}
          </p>
        </div>

      </div>

    </div>
  );
};

export default AdminDashboard;