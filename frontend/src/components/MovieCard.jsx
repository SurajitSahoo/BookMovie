import { motion } from "framer-motion";

const MovieCard = ({
  movie,
  onBook
}) => {

  return (

    <motion.div

      whileHover={{
        scale:1.05
      }}

      className="
      bg-white/10
      backdrop-blur-lg
      rounded-2xl
      overflow-hidden
      shadow-xl
      "
    >

      <img
        src={movie.imageUrl}
        alt={movie.name}
        className="
        h-72
        w-full
        object-cover
        "
      />

      <div
        className="
        p-4
        "
      >

        <h2
          className="
          text-xl
          font-bold
          "
        >
          {movie.name}
        </h2>

        <p
          className="
          text-gray-300
          mt-2
          "
        >
          {movie.genre}
        </p>

        <p
          className="
          text-gray-400
          "
        >
          {movie.language}
        </p>

        <p
          className="
          text-gray-400
          "
        >
          {movie.duration} mins
        </p>

        <button

          onClick={() =>
            onBook(movie)
          }

          className="
          w-full
          mt-4
          bg-red-500
          py-2
          rounded-xl
          hover:bg-red-600
          "
        >

          Book Now

        </button>

      </div>

    </motion.div>

  );
};

export default MovieCard;