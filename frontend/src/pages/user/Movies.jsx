import {
  useEffect,
  useState
} from "react";

import {
  toast
} from "react-toastify";

import MovieCard from "../../components/MovieCard";

import {
  getAllMovies
} from "../../services/movieService";

const Movies = () => {

  const [movies,setMovies] =
    useState([]);

  const [loading,setLoading] =
    useState(true);

  useEffect(() => {

    fetchMovies();

  },[]);

  const fetchMovies =
    async () => {

      try {

        const data =
          await getAllMovies();

        setMovies(data);

      }
      catch(error){

        toast.error(
          "Failed to load movies"
        );
      }
      finally{
        setLoading(false);
      }
    };

  const handleBook =
    (movie) => {

      toast.info(
        `${movie.name} selected`
      );

      // Part 3B:
      // Booking Modal
    };

  if(loading){

    return (

      <div
        className="
        text-center
        mt-20
        "
      >
        Loading...
      </div>

    );
  }

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
        mb-8
        "
      >

        All Movies

      </h1>

      <div

        className="
        grid
        sm:grid-cols-2
        lg:grid-cols-4
        gap-6
        "
      >

        {
          movies.map(movie => (

            <MovieCard

              key={movie.id}

              movie={movie}

              onBook={handleBook}

            />

          ))
        }

      </div>

    </div>

  );
};

export default Movies;