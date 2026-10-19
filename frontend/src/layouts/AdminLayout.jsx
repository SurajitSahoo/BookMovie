import { Outlet } from "react-router-dom";
import AdminSidebar from "../components/AdminSidebar";

const AdminLayout = () => {
  return (
    <div
      className="
      flex
      min-h-screen
      bg-slate-900
      text-white
      "
    >
      <AdminSidebar />

      <div className="flex-1 p-6">
        <Outlet />
      </div>
    </div>
  );
};

export default AdminLayout;