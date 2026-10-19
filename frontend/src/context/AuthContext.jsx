import { createContext, useContext, useState } from "react";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {

  const [user,setUser] = useState({
    token: localStorage.getItem("token"),
    roles: JSON.parse(localStorage.getItem("roles") || "[]"),
    userId: localStorage.getItem("userId"),
  });

  const login = (data) => {

    localStorage.setItem(
      "token",
      data.jwtToken
    );

    localStorage.setItem(
      "roles",
      JSON.stringify(data.roles)
    );

    localStorage.setItem(
      "userId",
      data.userId
    );

    setUser({
      token:data.jwtToken,
      roles:data.roles,
      userId:data.userId
    });
  };

  const logout = () => {

    localStorage.clear();

    setUser({
      token:null,
      roles:[],
      userId:null
    });
  };

  return (
    <AuthContext.Provider
      value={{
        user,
        login,
        logout
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth=()=>useContext(AuthContext);