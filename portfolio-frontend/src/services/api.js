import axios from "axios";

const API = axios.create({
  baseURL: process.env.REACT_APP_API_URL
});

// Interceptor para JWT
API.interceptors.request.use(config => {
     const token = localStorage.getItem("token");

     if (token && !config.url.includes("/auth")) {
       config.headers.Authorization = `Bearer ${token}`;
     }

     return config;
    });
// RESPONSE → detecta token expirado
API.interceptors.response.use(
  res => res,
  err => {
    const url = err.config?.url;

    if (url?.includes("/auth/login") || url?.includes("/visitas")) {
          return Promise.reject(err);
    }

    if (err.response && (err.response.status === 401 || err.response.status === 403)) {
      console.log("Sesion inválida");

      localStorage.removeItem("token");
      localStorage.removeItem("user");

      window.location.href = "/login";
    }

    return Promise.reject(err);
  }
);

export default API;

// ENDPOINTS
export const getUsuario = () => API.get("/usuarios/1");
export const getProyectos = () => API.get("/proyectos");
export const getHerramientas = () => API.get("/herramientas");
export const getHerramientasPorProyecto = (id) =>
  API.get(`/proyecto-herramientas/${id}`);
export const enviarContacto = (data) => API.post("/contactos", data);