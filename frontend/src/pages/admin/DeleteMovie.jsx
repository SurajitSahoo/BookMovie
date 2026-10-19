import {
  useEffect,
  useState
} from "react";

import {
  getMovies,
  deleteMovie
} from "../../services/movieService";

const DeleteMovie = ()=>{

  const [movies,setMovies] =
    useState([]);

  const loadMovies =
    async()=>{

      const data =
        await getMovies();

      setMovies(data);
    };

  useEffect(()=>{
    loadMovies();
  },[]);

  return(

    <div>

      <h1
        className="
        text-3xl
        mb-5
        "
      >
        Delete Movie
      </h1>

      {
        movies.map(movie=>(
          <div

            key={movie.id}

            className="
            flex
            justify-between
            bg-slate-800
            p-4
            mb-3
            rounded-lg
            "
          >

            <span>
              {movie.name}
            </span>

            <button

              onClick={
                async()=>{

                  await deleteMovie(
                    movie.id
                  );

                  loadMovies();
                }
              }

              className="
              bg-red-500
              px-4
              py-2
              rounded
              "
            >

              Delete

            </button>

          </div>
        ))
      }

    </div>
  );
};

export default DeleteMovie;