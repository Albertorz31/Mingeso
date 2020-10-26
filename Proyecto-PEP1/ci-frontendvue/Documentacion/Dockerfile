#build stage
FROM node:14.3.0-alpine3.11 as build-stage

# Create an application directory
RUN mkdir -p /app

# The /app directory should act as the main application directory
WORKDIR /app

# Copy the app package and package-lock.json file
COPY package*.json ./

# Install node packages
RUN npm install

# Copy or project directory (locally) in the current directory of our docker image (/app)
COPY . .

# Build the app
RUN npm run build

#production stage
FROM nginx:1.18.0-alpine as production-stage
COPY --from=build-stage /app/dist /usr/share/nginx/html


EXPOSE 80
CMD [ "nginx", "-g", "daemon off;" ]




 


