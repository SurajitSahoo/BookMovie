import { motion } from "framer-motion";

const Home = () => {

  return (

    <div>

      <div

        className="
        h-[80vh]
        flex
        items-center
        justify-center
        bg-gradient-to-r
        from-red-700
        via-black
        to-yellow-600
        px-6
        "
      >

        <motion.div

          initial={{
            opacity:0,
            y:50
          }}

          animate={{
            opacity:1,
            y:0
          }}

          transition={{
            duration:0.8
          }}

          className="
          text-center
          "
        >

          <h1

            className="
            text-4xl
            md:text-7xl
            font-bold
            "
          >

            🎬 Watch Latest Movies

          </h1>

          <p

            className="
            mt-6
            text-lg
            md:text-2xl
            text-gray-200
            "
          >

            Book Your Favourite
            Movies Instantly

          </p>

          <button

            className="
            mt-8
            bg-yellow-400
            text-black
            px-8
            py-3
            rounded-xl
            font-bold
            hover:scale-105
            transition
            "
          >

            Explore Movies

          </button>

        </motion.div>

      </div>

      <div
        className="
        py-12
        px-6
        "
      >

        <h2

          className="
          text-3xl
          font-bold
          mb-6
          "
        >
          Featured Movies
        </h2>

        <div

          className="
          grid
          sm:grid-cols-2
          lg:grid-cols-4
          gap-6
          "
        >

          <img
            src="https://images.unsplash.com/photo-1489599849927-2ee91cede3ba"
            className="rounded-xl"
          />

          <img
            src="https://images.unsplash.com/photo-1517604931442-7e0c8ed2963c"
            className="rounded-xl"
          />

          <img
            src="https://images.unsplash.com/photo-1536440136628-849c177e76a1"
            className="rounded-xl"
          />

          <img
            src="https://images.unsplash.com/photo-1478720568477-152d9b164e26"
            className="rounded-xl"
          />

        </div>

      </div>

    </div>
  );
};

export default Home;