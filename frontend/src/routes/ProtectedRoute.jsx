import { Navigate } from "react-router-dom";

import { useAuth } from "../context/AuthContext";

const ProtectedRoute = ({
  children,
  role
}) => {

  const { user } = useAuth();

  if (!user) {
    return <Navigate to="/login" />;
  }

  if (
    role &&
    !user.roles.includes(role)
  ) {
    return (
      <Navigate
        to="/login"
      />
    );
  }

  return children;
};

export default ProtectedRoute;