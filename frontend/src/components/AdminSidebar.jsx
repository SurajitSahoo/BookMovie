import { Link } from "react-router-dom";

const AdminSidebar = () => {
  return (
    <div
      className="
      w-64
      min-h-screen
      bg-slate-950
      border-r
      border-slate-800
      "
    >
      <div
        className="
        text-center
        text-3xl
        font-bold
        py-6
        "
      >
        <span className="text-cyan-400">
          Movie
        </span>

        <span className="text-pink-500">
          Hub
        </span>
      </div>

      <nav
        className="
        flex
        flex-col
        gap-2
        px-4
        "
      >
        <Link
          to="/admin"
          className="hover:bg-slate-800 p-3 rounded-lg"
        >
          Dashboard
        </Link>

        <Link
          to="/admin/add-movie"
          className="hover:bg-slate-800 p-3 rounded-lg"
        >
          Add Movie
        </Link>

        <Link
          to="/admin/update-movie"
          className="hover:bg-slate-800 p-3 rounded-lg"
        >
          Update Movie
        </Link>

        <Link
          to="/admin/delete-movie"
          className="hover:bg-slate-800 p-3 rounded-lg"
        >
          Delete Movie
        </Link>

        <Link
          to="/admin/create-show"
          className="hover:bg-slate-800 p-3 rounded-lg"
        >
          Create Show
        </Link>

        <Link
          to="/admin/bookings"
          className="hover:bg-slate-800 p-3 rounded-lg"
        >
          All Bookings
        </Link>
      </nav>
    </div>
  );
};

export default AdminSidebar;