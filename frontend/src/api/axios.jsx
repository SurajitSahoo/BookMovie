import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Content-Type": "application/json",
  },
});

// Add JWT token to requests
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");

    // Don't send token on login/register endpoints
    if (
      token &&
      !config.url.includes("/login") &&
      !config.url.includes("/register")
    ) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => Promise.reject(error)
);

// Handle expired/invalid token
api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (
      error.response &&
      error.response.status === 401
    ) {
      localStorage.removeItem("token");
      localStorage.removeItem("user");

      alert("Session expired. Please log in again.");

      window.location.href = "/login";
    }

    return Promise.reject(error);
  }
);

export default api;