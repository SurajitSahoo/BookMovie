import { useState } from "react";

import {
  addMovie
} from "../../services/movieService";

import {
  toast
} from "react-toastify";

const AddMovie = () => {

  const [movie,setMovie] =
    useState({

      name:"",
      description:"",
      genre:"",
      duration:"",
      language:"",
      imageUrl:""

    });

  const submitMovie =
    async(e)=>{

      e.preventDefault();

      try{

        await addMovie(movie);

        toast.success(
          "Movie Added"
        );

      }catch{

        toast.error(
          "Failed"
        );
      }
    };

  return (

    <form
      onSubmit={submitMovie}
      className="
      max-w-xl
      space-y-4
      "
    >

      <h1
        className="
        text-3xl
        font-bold
        "
      >
        Add Movie
      </h1>

      {
        Object.keys(movie)
        .map(field=>(
          <input
            key={field}
            placeholder={field}
            className="
            w-full
            p-3
            bg-slate-800
            rounded-lg
            "
            onChange={(e)=>
              setMovie({
                ...movie,
                [field]:
                e.target.value
              })
            }
          />
        ))
      }

      <button
        className="
        bg-cyan-500
        px-6
        py-3
        rounded-lg
        "
      >
        Add Movie
      </button>

    </form>
  );
};

export default AddMovie;