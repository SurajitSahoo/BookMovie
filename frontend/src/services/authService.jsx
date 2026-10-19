import api from "../api/axios";

export const loginUser = async (data) => {
  const response = await api.post(
    "/api/auth/login",
    data
  );

  return response.data;
};

export const registerUser = async (data) => {
  const response = await api.post(
    "/api/auth/registernormaluser",
    data
  );

  return response.data;
};