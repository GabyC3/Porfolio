import API from "./api";

export const login = async (correo, password) => {
  const res = await API.post("/auth/login", {
    correo,
    password
  });

  localStorage.setItem("token", res.data.token);
  localStorage.setItem("user", JSON.stringify(res.data));

  return res.data;
};

export const logout = () => {
  localStorage.removeItem("token");
  localStorage.removeItem("user");
};

export const getUser = () => {
  return JSON.parse(localStorage.getItem("user"));
};

export const isAuth = () => {
  return !!localStorage.getItem("token");
};