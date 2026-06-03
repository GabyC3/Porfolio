import Navbar from "../components/Navbar";
import Hero from "../components/Hero";
import About from "../components/About";
import Contacto from "../components/Contacto";
import Proyecto from "../components/Proyectos";
import Footer from "../components/Footer";
import "../i18n";
import { useEffect } from "react";
import api from "../services/api";

function Home() {
    useEffect(() => {
     const alreadyRegistered =
         sessionStorage.getItem("visitRegistered");

       if (!alreadyRegistered) {

         api.post("/visitas")
           .then(() => {
             sessionStorage.setItem(
               "visitRegistered",
               "true"
             );
           });
       }
    }, []);

  return (
    <>
      <Navbar />
      <Hero />
      <About />
      <Proyecto />
      <Contacto />
      <Footer />
    </>
  );
}

export default Home;