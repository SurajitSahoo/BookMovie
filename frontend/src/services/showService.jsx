import api from "../api/axios";

export const createShow =
async(data)=>{

  const res =
    await api.post(
      "/api/show/createshow",
      data
    );

  return res.data;
};