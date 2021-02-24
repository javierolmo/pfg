# Download pfg-frontend
FROM alpine/git AS git
WORKDIR /app
RUN git clone https://JaviOlmoI:0b2b13ca3426515ce8de94229b470eb4543ea1c9@github.com/JaviOlmoI/pfg-frontend.git

#BUILD
FROM node:latest AS node
WORKDIR /usr/src/app
COPY --from=0 /app/pfg-frontend .
RUN npm install
RUN npm run build -- --prod --aot

#RUN
FROM nginx:latest
COPY --from=git /app/pfg-frontend/nginx.conf /etc/nginx/nginx.conf
COPY --from=node /usr/src/app/dist /usr/share/nginx/html
CMD ["/bin/sh",  "-c",  "envsubst < /usr/share/nginx/html/assets/env/env.template.js > /usr/share/nginx/html/assets/env/env.js && exec nginx -g 'daemon off;'"]
EXPOSE 80
