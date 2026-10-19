import { useState } from "react";

import { Link } from "react-router-dom";

import { motion } from "framer-motion";

import { toast } from "react-toastify";

import { registerUser } from "../services/authService";

const Register = () => {

  const [formData, setFormData] =
    useState({
      username: "",
      email: "",
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

      await registerUser(formData);

      toast.success(
        "Registration Successful"
      );

      setFormData({
        username: "",
        email: "",
        password: ""
      });

    } catch (error) {

      toast.error(
        error?.response?.data ||
        "Registration Failed"
      );
    }
  };

  return (
    <div
      className="
      min-h-screen
      flex
      justify-center
      items-center
      bg-gradient-to-br
      from-black
      via-slate-900
      to-red-900
      px-4
      "
    >

      <motion.div

        initial={{
          opacity:0,
          scale:0.8
        }}

        animate={{
          opacity:1,
          scale:1
        }}

        className="
        w-full
        max-w-md
        bg-white/10
        backdrop-blur-lg
        border
        border-white/20
        rounded-3xl
        p-8
        shadow-2xl
        "
      >

        <div
          className="
          text-center
          mb-8
          "
        >

          <h1
            className="
            text-4xl
            font-bold
            "
          >

            <span className="text-red-500">
              Movie
            </span>

            <span className="text-yellow-400">
              Booking
            </span>

          </h1>

          <p
            className="
            text-gray-300
            mt-2
            "
          >
            Create your account
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
            type="email"
            name="email"
            placeholder="Email"
            value={formData.email}
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
              scale:1.05
            }}

            whileTap={{
              scale:0.95
            }}

            className="
            w-full
            bg-yellow-500
            hover:bg-yellow-600
            text-black
            py-3
            rounded-xl
            font-bold
            "
          >

            Register

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

            Already have account?

            <Link
              to="/login"
              className="
              text-red-400
              ml-2
              "
            >
              Login
            </Link>

          </p>

        </div>

      </motion.div>

    </div>
  );
};

export default Register;