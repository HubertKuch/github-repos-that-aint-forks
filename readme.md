# Java SDK for Github API
Default port: 8080

### Tech stack
Uses `java-21`, `spring 3.5.x` and for http `RestClient` api

### Available endpoints

> `/api/v1/gh/repos/{owner}` </br>
where `owner` is username of repository owner. For example `https://github.com/torvalds/linux` in that url `onwer` is `torvalds`.

Response schema:
```json
{
    "owner": String,
    "repos": [
        {
            "ownerLogin": String,
            "name": String,
            "branches": [
                {
                    "name": String,
                    "lastCommitSha": String
                }
            ]
        }
    ]
}
```

Author: Hubert Kuch
