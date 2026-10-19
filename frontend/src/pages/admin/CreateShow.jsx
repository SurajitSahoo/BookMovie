import {
  useState
} from "react";

import {
  createShow
} from "../../services/showService";

import {
  toast
} from "react-toastify";

const CreateShow = ()=>{

  const [show,setShow] =
    useState({

      showTime:"",
      price:"",
      movieId:"",
      theaterId:""

    });

  const submit =
    async(e)=>{

      e.preventDefault();

      try{

        await createShow(show);

        toast.success(
          "Show Created"
        );

      }catch{

        toast.error(
          "Failed"
        );
      }
    };

  return(

    <form
      onSubmit={submit}
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
        Create Show
      </h1>

      <input
        type="datetime-local"
        className="
        w-full
        p-3
        bg-slate-800
        rounded
        "
        onChange={(e)=>
          setShow({
            ...show,
            showTime:
            e.target.value
          })
        }
      />

      <input
        placeholder="Price"
        className="
        w-full
        p-3
        bg-slate-800
        rounded
        "
        onChange={(e)=>
          setShow({
            ...show,
            price:
            e.target.value
          })
        }
      />

      <input
        placeholder="Movie Id"
        className="
        w-full
        p-3
        bg-slate-800
        rounded
        "
        onChange={(e)=>
          setShow({
            ...show,
            movieId:
            e.target.value
          })
        }
      />

      <input
        placeholder="Theater Id"
        className="
        w-full
        p-3
        bg-slate-800
        rounded
        "
        onChange={(e)=>
          setShow({
            ...show,
            theaterId:
            e.target.value
          })
        }
      />

      <button
        className="
        bg-green-500
        px-6
        py-3
        rounded
        "
      >
        Create Show
      </button>

    </form>
  );
};

export default CreateShow;