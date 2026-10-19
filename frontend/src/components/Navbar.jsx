import { useState } from "react";

import {
  Link,
  useNavigate
} from "react-router-dom";

import {
  FaBars,
  FaTimes
} from "react-icons/fa";

import { useAuth } from "../context/AuthContext";

const Navbar = () => {

  const [open,setOpen] = useState(false);

  const { logout } = useAuth();

  const navigate = useNavigate();

  const handleLogout = () => {

    logout();

    navigate("/login");
  };

  return (
    <nav
      className="
      bg-black
      px-6
      py-4
      shadow-lg
      "
    >

      <div
        className="
        flex
        justify-between
        items-center
        "
      >

        <h1
          className="
          text-2xl
          md:text-3xl
          font-bold
          "
        >

          <span
            className="
            text-red-500
            "
          >
            Movie
          </span>

          <span
            className="
            text-yellow-400
            "
          >
            Booking
          </span>

        </h1>

        <div
          className="
          hidden
          md:flex
          gap-8
          items-center
          "
        >

          <Link to="/user/home">
            Home
          </Link>

          <Link to="/user/movies">
            Movies
          </Link>

          <Link to="/user/bookings">
            My Bookings
          </Link>

          <Link to="/user/tickets">
            Tickets
          </Link>

          <button
            onClick={handleLogout}
            className="
            bg-red-500
            px-4
            py-2
            rounded-lg
            "
          >
            Logout
          </button>

        </div>

        <button
          className="
          md:hidden
          text-2xl
          "
          onClick={() =>
            setOpen(!open)
          }
        >

          {
            open
            ?
            <FaTimes/>
            :
            <FaBars/>
          }

        </button>

      </div>

      {
        open && (

          <div
            className="
            md:hidden
            flex
            flex-col
            gap-4
            mt-5
            "
          >

            <Link to="/user/home">
              Home
            </Link>

            <Link to="/user/movies">
              Movies
            </Link>

            <Link to="/user/bookings">
              My Bookings
            </Link>

            <Link to="/user/tickets">
              Tickets
            </Link>

            <button
              onClick={handleLogout}
              className="
              bg-red-500
              py-2
              rounded-lg
              "
            >
              Logout
            </button>

          </div>

        )
      }

    </nav>
  );
};

export default Navbar;