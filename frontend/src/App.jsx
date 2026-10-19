import { Routes, Route } from "react-router-dom";

import Login from "./pages/Login";
import Register from "./pages/Register";

import UserLayout from "./layouts/UserLayout";
import AdminLayout from "./layouts/AdminLayout";

import Home from "./pages/user/Home";
import Movies from "./pages/user/Movies";
import Bookings from "./pages/user/Bookings";
import Tickets from "./pages/user/Tickets";

import Dashboard from "./pages/admin/Dashboard";
import AddMovie from "./pages/admin/AddMovie";
import CreateShow from "./pages/admin/CreateShow";
import AddTheater from "./pages/admin/AddTheater";
import AllBookings from "./pages/admin/AllBookings";
import UpdateMovie from "./pages/admin/UpdateMovie";

import ProtectedRoute from "./routes/ProtectedRoute";

function App() {
  return (
    <Routes>

      <Route path="/" element={<Login />} />

      <Route path="/login" element={<Login />} />

      <Route path="/register" element={<Register />} />

      <Route
        path="/user"
        element={
          <ProtectedRoute role="ROLE_USER">
            <UserLayout />
          </ProtectedRoute>
        }
      >
        <Route path="home" element={<Home />} />
        <Route path="movies" element={<Movies />} />
        <Route path="bookings" element={<Bookings />} />
        <Route path="tickets" element={<Tickets />} />
      </Route>

      <Route
        path="/admin"
        element={
          <ProtectedRoute role="ROLE_ADMIN">
            <AdminLayout />
          </ProtectedRoute>
        }
      >
        <Route path="dashboard" element={<Dashboard />} />
        <Route path="add-movie" element={<AddMovie />} />
        <Route path="create-show" element={<CreateShow />} />
        <Route path="add-theater" element={<AddTheater />} />
        <Route path="bookings" element={<AllBookings />} />
        <Route path="update-movie" element={<UpdateMovie />} />
      </Route>

    </Routes>
  );
}

export default App;