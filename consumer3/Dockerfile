#Build
FROM mcr.microsoft.com/dotnet/core/sdk:3.1 AS build
COPY . /app
WORKDIR /app
RUN dotnet restore
RUN dotnet publish -c Release -o out

#Publish
FROM mcr.microsoft.com/dotnet/core/aspnet:3.1 AS runtime
WORKDIR /app
COPY --from=build /app/out ./
ENTRYPOINT ["dotnet", "consumer3.dll"]
EXPOSE 80