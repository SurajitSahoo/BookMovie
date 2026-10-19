import {
 useEffect,
 useState
} from "react";

import {
 getAllMovies,
 updateMovie
}
from "../../services/movieService";

import {
 toast
}
from "react-toastify";

const UpdateMovie = () => {

 const [movies,setMovies] =
 useState([]);

 const [selectedMovie,
 setSelectedMovie] =
 useState(null);

 useEffect(()=>{

  loadMovies();

 },[]);

 const loadMovies =
 async()=>{

  const data =
  await getAllMovies();

  setMovies(data);

 };

 const submitUpdate =
 async(e)=>{

  e.preventDefault();

  try{

   await updateMovie(
    selectedMovie.id,
    selectedMovie
   );

   toast.success(
    "Movie Updated"
   );

   loadMovies();

  }catch{

   toast.error(
    "Update Failed"
   );
  }
 };

 return(

  <div>

   <h1
   className="
   text-3xl
   mb-5
   "
   >
    Update Movie
   </h1>

   <select

   className="
   bg-slate-800
   p-3
   rounded
   mb-5
   "

   onChange={(e)=>{

    const movie =
    movies.find(
    m =>
    m.id ===
    Number(
     e.target.value
    )
   );

   setSelectedMovie(
    movie
   );

   }}

   >

    <option>
     Select Movie
    </option>

    {
     movies.map(
      movie => (

       <option
       key={movie.id}
       value={movie.id}
       >

       {movie.name}

       </option>

      )
     )
    }

   </select>

   {
    selectedMovie && (

     <form
     onSubmit={
      submitUpdate
     }
     >

      <input

      value={
       selectedMovie.name
      }

      onChange={(e)=>

       setSelectedMovie({

        ...selectedMovie,

        name:
        e.target.value

       })

      }

      className="
      block
      w-full
      p-3
      mb-3
      bg-slate-800
      rounded
      "

      />

      <button

      className="
      bg-cyan-500
      px-6
      py-3
      rounded
      "

      >

       Update

      </button>

     </form>

    )
   }

  </div>

 );
};

export default UpdateMovie;