import api from "../api/axios";

export const createBooking = async (bookingData) => {
  const response = await api.post(
    "/api/booking/createbooking",
    bookingData
  );

  return response.data;
};

export const getUserBookings = async (userId) => {
  const response = await api.get(
    `/api/booking/getuserbookings/${userId}`
  );

  return response.data;
};

export const cancelBooking = async (bookingId) => {
  const response = await api.put(
    `/api/booking/${bookingId}/cancel`
  );

  return response.data;
};