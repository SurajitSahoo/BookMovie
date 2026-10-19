import api from "../api/axios";

export const getAllMovies = async () => {
  const res = await api.get("/api/movies/getallmovies");
  return res.data;
};

export const getMovieById = async (id) => {
  const res = await api.get(`/api/movies/${id}`);
  return res.data;
};

export const addMovie = async (movieData) => {
  const res = await api.post(
    "/api/movies/addmovie",
    movieData
  );
  return res.data;
};

export const updateMovie = async (id, movieData) => {
  const res = await api.put(
    `/api/movies/updatemovie/${id}`,
    movieData
  );
  return res.data;
};

export const deleteMovie = async (id) => {
  const res = await api.delete(
    `/api/movies/deletemovie/${id}`
  );
  return res.data;
};