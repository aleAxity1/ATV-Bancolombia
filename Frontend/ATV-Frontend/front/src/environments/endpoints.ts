import { environment } from './environment';

export const Endpoints = {
  security: {
    login: `${environment.baseUrl}/login?delay=2`,
  },
  demo: {
    colors: `${environment.baseUrl}/unknown`,
  },
  users: {
    users: `${environment.usersURL}/users`,
    // http://localhost:9090 + /users -> http://localhost:9090/users
  },
};

export const TokenExcludedEndpoints = ['login'];
