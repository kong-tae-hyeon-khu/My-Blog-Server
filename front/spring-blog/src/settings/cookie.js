import {Cookies} from "react-cookie";

const cookie = new Cookies();

export const setCookie = (name, value) => {
    return cookie.set(name,value,{maxAge : 60 * 60 * 3, path : "/"});
}

export const getCookie = (name) => {
    return cookie.get(name);
}

export const removeCookie = (name) => {
    return cookie.remove(name);
}