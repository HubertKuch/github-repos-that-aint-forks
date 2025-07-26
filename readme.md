# Java SDK for Github API
Default port: 8080

### Available endpoints

<details>
<summary>Get repos</summary>

`/api/v1/gh/repos/{owner}` where `owner` is username of repository owner. For example `https://github.com/torvalds/linux` in that url `onwer` is `torvalds`.

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

</details>

Author: Hubert Kuch
