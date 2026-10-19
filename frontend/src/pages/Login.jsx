import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { motion } from "framer-motion";
import { toast } from "react-toastify";

import { loginUser } from "../services/authService";
import { useAuth } from "../context/AuthContext";

const Login = () => {

  const navigate = useNavigate();

  const { login } = useAuth();

  const [formData, setFormData] = useState({
    username: "",
    password: ""
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {

    e.preventDefault();

    try {

      const response =
        await loginUser(formData);

      login(response);

      toast.success("Login Successful");

      if (
        response.roles.includes(
          "ROLE_ADMIN"
        )
      ) {
        navigate("/admin/dashboard");
      } else {
        navigate("/user/home");
      }

    } catch (error) {

      toast.error(
        error?.response?.data ||
        "Invalid Credentials"
      );
    }
  };

  return (
    <div
      className="
      min-h-screen
      flex
      items-center
      justify-center
      bg-gradient-to-br
      from-slate-950
      via-slate-900
      to-red-900
      px-4
      "
    >

      <motion.div

        initial={{
          opacity: 0,
          y: 50
        }}

        animate={{
          opacity: 1,
          y: 0
        }}

        transition={{
          duration: 0.5
        }}

        className="
        w-full
        max-w-md
        bg-white/10
        backdrop-blur-lg
        border
        border-white/20
        rounded-3xl
        shadow-2xl
        p-8
        "
      >

        <div className="text-center mb-8">

          <h1
            className="
            text-4xl
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

          <p
            className="
            text-gray-300
            mt-2
            "
          >
            Login to continue
          </p>

        </div>

        <form
          onSubmit={handleSubmit}
          className="space-y-5"
        >

          <input
            type="text"
            name="username"
            placeholder="Username"
            value={formData.username}
            onChange={handleChange}
            required
            className="
            w-full
            p-3
            rounded-xl
            bg-slate-800
            text-white
            outline-none
            "
          />

          <input
            type="password"
            name="password"
            placeholder="Password"
            value={formData.password}
            onChange={handleChange}
            required
            className="
            w-full
            p-3
            rounded-xl
            bg-slate-800
            text-white
            outline-none
            "
          />

          <motion.button

            whileHover={{
              scale: 1.05
            }}

            whileTap={{
              scale: 0.95
            }}

            className="
            w-full
            bg-red-500
            hover:bg-red-600
            py-3
            rounded-xl
            font-semibold
            transition
            "
          >

            Login

          </motion.button>

        </form>

        <div
          className="
          mt-6
          text-center
          "
        >

          <p
            className="
            text-gray-300
            "
          >

            Don't have an account?

            <Link
              to="/register"
              className="
              text-yellow-400
              ml-2
              "
            >
              Register
            </Link>

          </p>

        </div>

      </motion.div>

    </div>
  );
};

export default Login;